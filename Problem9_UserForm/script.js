console.log("Sakshi");

let obj={
    "nehasahu789@gmail.com":"nehasahu",
    "masai@gmail.com":"masai",
    "goldlocks0704@gmail.com":"goldlock"
}

let signup_button = document.querySelector("#login-container form");

signup_button.addEventListener("submit",userDetails);

function userDetails(){
    event.preventDefault();
    let login_input_all = document.querySelectorAll("#login-container input");

    let inputObj = {};
    for(let i=0;i<login_input_all.length-1;i++){
        inputObj[login_input_all[i].id]=login_input_all[i].value;
    }

    console.log(inputObj);

    let flag=true;
    for(let k in obj){
    
        if(k==inputObj.username){
            if(obj[k]==inputObj.password){
                document.getElementById("login-message").textContent = "Login successful!";
                alert("Login Successfull")
                flag=false;
            }else{
                document.getElementById("login-message").textContent = "Login Failed!";
            }
        }
    }
    if(flag){
        alert("Wrong username or password")
    }
}