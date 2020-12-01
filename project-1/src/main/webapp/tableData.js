var tableContainer = document.getElementById("reimbTable");
var btn = document.getElementById("btn");
var btnPend = document.getElementById("btn-p");
var btnRes = document.getElementById("btn-r");
var baseUri = 'http://localhost:8080/project-1/ReimbursementView';
btn.addEventListener("click", function() {
    chooseStatus('all');
});
btnPend.addEventListener("click", function() {
    chooseStatus('pending');
});
btnRes.addEventListener("click", function() {
    chooseStatus('resolved');
});



//     var ourRequest = new XMLHttpRequest();
//     ourRequest.open('GET', `${baseUri}/?status=${chosenStatus}`);

//     ourRequest.onload = function () {
//     console.log(ourRequest.responseText);
//     var ourData = JSON.parse(ourRequest.responseText)

//     renderTableHTML(ourData);
// };
// ourRequest.send();
// });

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