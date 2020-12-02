var tableContainer = document.getElementById("reimbTable");
var btn = document.getElementById("btn");
var btnPend = document.getElementById("btn-p");
var btnRes = document.getElementById("btn-r");
var dropdown = document.getElementById("selectedAuthor");
var baseUri = 'http://localhost:8080/project-1/ReimbursementView';
var empUri = 'http://localhost:8080/project-1/EmployeeView';

document.addEventListener('DOMContentLoaded', function (){
    console.log('Page loaded')
    var ourRequest = new XMLHttpRequest();
    ourRequest.open('GET', `${empUri}/?scope=all`)

    ourRequest.onload = function () {
        console.log(ourRequest.responseText);
        var ourData = JSON.parse(ourRequest.responseText);

        populateDropdown(ourData);
    }
    ourRequest.send();
});

btn.addEventListener("click", function() {
    chooseStatus('all');
});
btnPend.addEventListener("click", function() {
    chooseStatus('pending');
});
btnRes.addEventListener("click", function() {
    chooseStatus('resolved');
});

dropdown.addEventListener("change", function () {
    console.log(dropdown.value + 'selected in dropdown')
    var ourRequest = new XMLHttpRequest();
    ourRequest.open('GET', `${baseUri}/?author=${dropdown.value}`);

    ourRequest.onload = function () {
    console.log(ourRequest.responseText);
    var ourData = JSON.parse(ourRequest.responseText)

    renderTableHTML(ourData);
};
ourRequest.send();
})

function chooseStatus(chosenStatus){
    var ourRequest = new XMLHttpRequest();
    ourRequest.open('GET', `${baseUri}/?status=${chosenStatus}`);

    ourRequest.onload = function () {
    console.log(ourRequest.responseText);
    var ourData = JSON.parse(ourRequest.responseText)

    renderTableHTML(ourData);
};
ourRequest.send();
}

function populateDropdown(data){
    for (i=0; i<data.length; i++){
        // console.log(data[i].username);
        var op = document.createElement("option");
        op.innerText=data[i].username;
        dropdown.appendChild(op);
    }
    
}

function renderTableHTML(data){
    var col = [];
    for (i = 0; i < data.length; i++){
        for (var key in data[i]){
            if (col.indexOf(key) === -1){
                col.push(key);
            }
        }
    }
    var table = document.createElement("table");
    table.className = "table table-striped table-bordered table-sm";

    var tr = table.insertRow(-1); //inserts at end rows collection
    table.className = "table table-striped table-bordered table-sm";

    // Create Headers of Table
    for (var i = 0; i < col.length; i++){
        var th = document.createElement("th");
        th.scope="col";
        th.innerHTML = col[i];
        tr.appendChild(th)
    }

    // Insert JSON data into cells
    for (var i = 0; i < data.length; i++){
        tr = table.insertRow(-1);

        for (var j = 0; j < col.length; j++) {
            var tabCell = tr.insertCell(-1);

            if (data[i][col[j]] === null){
                tabCell.innerHTML = 'none';
            } 
            else if (typeof(data[i][col[j]]) === 'object'){ //output just 1 property for author, status & type objects
                var index = [];
                for (var x in data[i][col[j]]){
                    index.push(x);
                }

                tabCell.innerHTML = data[i][col[j]][index[1]];
            }
            else {
                tabCell.innerHTML = data[i][col[j]];
            }
            
        }
    }

    tableContainer.innerHTML = "";
    tableContainer.appendChild(table);
}