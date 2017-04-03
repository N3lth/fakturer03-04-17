function odwrocString() {
    var url = HOST + '/api/odwrocString';
    var params = '?stringDoOdwrocenia=' + document.getElementById('stringDoOdwrocenia').value;
    document.getElementById('odwroconyString').value = httpGet(url + params);
}

function dodajWartosci() {
    var url = HOST + '/api/dodajWartosci';
    var postData = {
        x: parseInt(document.getElementById('liczbaX').value),
        y: parseInt(document.getElementById('liczbaY').value)
    };
    var response = JSON.parse(httpPost(url, postData));
    document.getElementById('wynik').value = response.wynik;
    document.getElementById('wiadomosc').value = response.wiadomosc;
}

function dodajZKonsoli(x, y) {
    var result = x + y;
    return result;
}