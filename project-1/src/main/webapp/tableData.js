var tableContainer = document.getElementById("reimbTable");
var btn = document.getElementById("btn");
btn.addEventListener("click", function() {
    var ourRequest = new XMLHttpRequest();
    ourRequest.open('GET', 'http://localhost:8080/project-1/ReimbursementView');

    ourRequest.onload = function () {
    console.log(ourRequest.responseText);
    var ourData = JSON.parse(ourRequest.responseText)

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

    var tr = table.insertRow(-1); //inserts at end rows collection

    // Create Headers of Table
    for (var i = 0; i < col.length; i++){
        var th = document.createElement("th");
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