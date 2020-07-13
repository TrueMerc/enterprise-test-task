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