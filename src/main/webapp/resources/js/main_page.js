function showEmployeeList() {
    var xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.open("GET", "./employeeList", true);
    xmlHttpRequest.responseType = 'json';
    xmlHttpRequest.send();
    xmlHttpRequest.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
            var array = xmlHttpRequest.response;
            for(var i = 0; i < array.length; ++i) {
                var table = document.getElementById('employees_table');
                var row = table.insertRow(table.rows.length);

                var nameCell = row.insertCell(0);
                var name = document.createTextNode(array[i].name);
                var id = document.createTextNode(array[i].id);
                var nameReference = document.createElement('a');
                nameReference.setAttribute('href', "./employee.html?id=" + array[i].id);
                nameReference.appendChild(name);
                nameCell.appendChild(nameReference);

                var ageCell = row.insertCell(1);
                var age = document.createTextNode(array[i].age);
                ageCell.appendChild(age);

                var workHoursCell = row.insertCell( 2);
                var workHours = document.createTextNode(array[i].work_hours);
                workHoursCell.appendChild(workHours);

                var addressCell = row.insertCell(3);
                var address = document.createTextNode(array[i].address);
                addressCell.appendChild(address);

                var districtCell = row.insertCell( 4);
                var district = document.createTextNode(array[i].district);
                districtCell.appendChild(district);

                var administrativeUnitCell = row.insertCell(5);
                var administrativeUnit = document.createTextNode(array[i].administrative_division);
                administrativeUnitCell.appendChild(administrativeUnit);
            }
        };
    }
}

function showEmployee() {
    const id= getParameterByName("id", location.href);
    const url = "./employeeInfo?id=" + id;
    var xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.responseType = 'json';
    xmlHttpRequest.open("GET", url);
    xmlHttpRequest.send();
    xmlHttpRequest.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
            // document.getElementById("server_response_text").innerHTML = this.responseText;
            var response = xmlHttpRequest.response;
            var table = document.getElementById('employee_table');
            var row = table.insertRow(table.rows.length);

            var nameCell = row.insertCell(0);
            var name = document.createTextNode(response.name);
            nameCell.appendChild(name);

            var ageCell = row.insertCell(1);
            var age = document.createTextNode(response.age);
            ageCell.appendChild(age);

            var workHoursCell = row.insertCell( 2);
            var workHours = document.createTextNode(response.work_hours);
            workHoursCell.appendChild(workHours);

            var addressCell = row.insertCell(3);
            var address = document.createTextNode(response.address);
            addressCell.appendChild(address);

            var districtCell = row.insertCell( 4);
            var district = document.createTextNode(response.district);
            districtCell.appendChild(district);

            var administrativeUnitCell = row.insertCell(5);
            var administrativeUnit = document.createTextNode(response.administrative_division);
            administrativeUnitCell.appendChild(administrativeUnit);
        };
    }
}

function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, '\\$&');
    var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, ' '));
}

function sortTable(columnId, isReference) {
    var table, rows, switching, i, x, y, shouldSwitch;
    table = document.getElementById("employees_table");
    switching = true;
    /* Make a loop that will continue until
    no switching has been done: */
    while (switching) {
        // Start by saying: no switching is done:
        switching = false;
        rows = table.rows;
        /* Loop through all table rows (except the
        first, which contains table headers): */
        for (i = 1; i < (rows.length - 1); i++) {
            // Start by saying there should be no switching:
            shouldSwitch = false;
            /* Get the two elements you want to compare,
            one from current row and one from the next: */
            if(isReference) {
                x = rows[i].getElementsByTagName("TD")[columnId].getElementsByTagName("A")[0];
                y = rows[i + 1].getElementsByTagName("TD")[columnId].getElementsByTagName("A")[0];
            }
            else {
                x = rows[i].getElementsByTagName("TD")[columnId];
                y = rows[i + 1].getElementsByTagName("TD")[columnId];
            }
            // Check if the two rows should switch place:
            if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                // If so, mark as a switch and break the loop:
                shouldSwitch = true;
                break;
            }
        }
        if (shouldSwitch) {
            /* If a switch has been marked, make the switch
            and mark that a switch has been done: */
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
        }
    }
}

// $('#name_header, #age_header, #district_header, #administrative_unit_header')
//     .wrapInner('<span title="Sort this column"/>')
//     .each(function(){
//
//         let table = document.getElementById("employees_table");
//         let th = $(this),
//             thIndex = th.index(),
//             inverse = false;
//
//         th.click(function(){
//
//             $(table).find('td').filter(function(){
//
//                 return $(this).index() === thIndex;
//
//             }).sortElements(function(a, b){
//
//                 return $.text([a]) > $.text([b]) ?
//                     inverse ? -1 : 1
//                     : inverse ? 1 : -1;
//
//             }, function(){
//
//                 // parentNode is the element we want to move
//                 return this.parentNode;
//
//             });
//
//             inverse = !inverse;
//
//         });
//
//     });