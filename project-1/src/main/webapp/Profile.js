var tableContainer = document.getElementById("empTable");
var userIdLoc = document.getElementById("userId");
var usernameLoc = document.getElementById("username");
var fNameLoc = document.getElementById("fName");
var lNameLoc = document.getElementById("lName");
var emailLoc = document.getElementById("email");
var roleLoc = document.getElementById("role");
var baseUri = 'http://localhost:8080/project-1/EmployeeView';

document.addEventListener('DOMContentLoaded', function() {
    console.log('Page loaded')
    var ourRequest = new XMLHttpRequest();
    ourRequest.open('GET', `${baseUri}`);

    ourRequest.onload = function () {
        console.log(ourRequest.responseText);
        var ourData = JSON.parse(ourRequest.responseText)
        renderHTML(ourData);
    };
ourRequest.send();
})

function renderHTML(data){
    userIdLoc.value = data.userId;
    usernameLoc.value = data.username;
    fNameLoc.value = data.firstName;
    lNameLoc.value = data.lastName;
    emailLoc.value = data.email;
    roleLoc.value = data.role.roleName;
}

