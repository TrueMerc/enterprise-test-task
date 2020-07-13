function fillPageElements() {
    fillSelect("district_select", "./districtList");
    fillSelect("administrative_unit_select", "./administrativeUnitList")
}

function  fillSelect(name, url) {
    let select = document.getElementById(name);

    let xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.responseType = 'json';
    xmlHttpRequest.open('GET', url);
    xmlHttpRequest.send();

    xmlHttpRequest.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
            // document.getElementById("server_response_text").innerHTML = this.responseText;
            let array = xmlHttpRequest.response;
            for(let i = 0; i < array.length; ++i) {
                let option = document.createElement("option");
                option.value = array[i].id;
                option.innerHTML = array[i].name;
                select.appendChild(option);
            }
        };
    }
}

function checkNewEmployee() {
    if(isInputEmpty("second_name_input")) {
        alert("Second name is empty.");
    }
    if(isInputEmpty("first_name_input")) {
        alert("First name is empty.");
    }
    if(isInputEmpty("patronymic_input")) {
        alert("Patronymic is empty.");
    }
    if(isInputEmpty("age_input")) {
        alert("Age is empty.");
    }
    if(isInputEmpty("address_input")) {
        alert("Address is empty.");
    }
}

function isInputEmpty(id) {
    let element = document.getElementById(id);
    let text = element.innerText;
    return text.length > 0 ? true : false;
}