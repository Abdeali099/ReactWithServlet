import React, { useState, useRef } from 'react';


function App() {

  const [dataOfStudent, setdataOfStudent] = useState([{ id: "", name: "", marks: "" }]);
  const [isRequested, setIsRequested] = useState(false);
  const formRef = useRef(null);

  const handleOnSubmitGET = (event) => {

    event.preventDefault();

    fetch("http://localhost:8090/DemoYoutube/getStudentData", {
      method: "GET"
    })
      .then(response => {
        console.log("Status: ", response.status);
        return response.json();
      })
      .then(data => {
        console.log("Response: ", data);
        setIsRequested(true);
        setdataOfStudent(data);
      })
      .catch(error => {
        console.error("Error: ", error);
      });
  };


  const handleOnSubmitPOST = (event) => {

    event.preventDefault();

    const formData = new FormData(formRef.current); 

    /* -> Only send particular field data...
    
    // Get the value of the field
    const nameOfUser = document.querySelector('#name_Label').value;

    // Create a new FormData object
    const formData = new FormData();

    // Append the desired field to the FormData object
    formData.append('user_name', nameOfUser); */

    
    fetch("http://localhost:8090/DemoYoutube/signup", {
      method: "POST",
      body: formData
    })
      .then(response => response.text())
      .then(data => {
        console.log("Response: ", data);

        // Update the output div
        let divResult = document.getElementById("output");
        divResult.innerHTML = data;
      })
      .catch(error => {
        console.error("Error: ", error);
      });
  };


  return (
    <>

      <div className="container" >

        <h4>Example of POST</h4>

        <form ref={formRef} onSubmit={handleOnSubmitPOST}>

          <div className="mb-3">
            <label htmlFor="name_Label" className="form-label">Name : </label>
            <input type="text" className="form-control" id="name_Label" name="user_name" />
          </div>

          <div className="mb-3">
            <label htmlFor="mobile_Label" className="form-label">Mobile : </label>
            <input type="text" className="form-control" id="mobile_Label" name="user_mobile" />
          </div>


          <button type="submit" className="btn btn-primary">Signup</button>

        </form>

        <br /><br />
        <div className="container text-align-center" id="output"></div>

      </div>

      <div className="container">

        <h4>Example of GET</h4>

        <form onSubmit={handleOnSubmitGET}>
          <input type='submit' className="waves-effect waves-light btn" value={"Get Data"} />
        </form>

        <table className='striped'>

          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Marks</th>
            </tr>
          </thead>

          <tbody>
            {isRequested && dataOfStudent.map((student, index) => (
              <tr key={index}>
                <td>{student.id}</td>
                <td>{student.name}</td>
                <td>{student.marks}</td>
              </tr>
            ))}
          </tbody>

        </table>

      </div>



    </>
  );
}

export default App;
