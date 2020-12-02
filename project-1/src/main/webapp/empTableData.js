var tableContainer = document.getElementById("empTable");
var btn = document.getElementById("btn");
var baseUri = 'http://localhost:8080/project-1/EmployeeView';

document.addEventListener('DOMContentLoaded', function () {
    // console.log('Page Loaded')
    var ourRequest = new XMLHttpRequest();
    ourRequest.open('GET', `${baseUri}/?scope=all`);

    ourRequest.onload = function () {
        // console.log(ourRequest.responseText);
        var ourData = JSON.parse(ourRequest.responseText);

        renderTableHTML(ourData);
    };
    ourRequest.send();
});

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

    var tr = table.insertRow(-1);

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
            if (j === 2){
                tabCell.innerHTML = '********';
                continue;
            }
            if (data[i][col[j]] === null){
                tabCell.innerHTML = 'none';
            } 
            else if (typeof(data[i][col[j]]) === 'object'){ //output just 1 property of object status
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