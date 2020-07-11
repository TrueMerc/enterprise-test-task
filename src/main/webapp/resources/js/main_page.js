function showResponse() {
    var xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.open("GET", "./message", true);
    xmlHttpRequest.responseType = 'text';
    xmlHttpRequest.send();
    xmlHttpRequest.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
            document.getElementById("server_response_text").innerHTML = this.responseText;
        };
    }
}