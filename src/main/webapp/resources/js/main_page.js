function showEmployeeList() {
    var xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.open("GET", "./employeeList", true);
    xmlHttpRequest.responseType = 'json';
    xmlHttpRequest.send();
    xmlHttpRequest.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
            // document.getElementById("server_response_text").innerHTML = this.responseText;
            var array = xmlHttpRequest.response;
            for(var i = 0; i < array.length; ++i) {
                var table = document.getElementById('users_table');
                var row = table.insertRow(table.rows.length);

                var nameCell = row.insertCell(0);
                var name = document.createTextNode(array[i].name);
                nameCell.appendChild(name);

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