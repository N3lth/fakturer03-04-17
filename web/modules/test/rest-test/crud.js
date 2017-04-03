var userTableDataX = [
    [1, 'Jan', 'Kowalski', 'j.kowalski', new Date()],
    [2, 'Adam', 'Nowak', 'a.nowak', new Date()],
    [3, 'Stefan', 'Batory', 's.batory', new Date()],
    [4, 'Anna', 'Kowalska', 'a.kowalska', new Date()],
    [5, 'Zenon', 'Zenon', 'z.zenon', new Date()],
    [6, 'Krzysztof', 'Nazwisko', 'k.nazwisko', new Date()]
];
var userTableData = [];
function createUserTable() {
    $(document).ready(function() {
        $('#user-table').DataTable( {
            data: userTableData,
            columns: [
                { title: "Id" },
                { title: "Imię" },
                { title: "Nazwisko" },
                { title: "Login" },
                { title: "Data utworzenia" }
            ]
        } );
    });
}

function createUserTableEvents() {
    $('#user-table').on('click', 'tr', function(){
        var table =  $('#user-table').dataTable();
        var row = table.fnGetData(this);
        getUserDataForForm(row[0]); // jezeli wszystko poszlo dobrze, w kolumnie 0 powinien znajdowac sie ID
    })
}

function getUserDataForTable() {
    userTableData = userTableDataX;
    reinitializeUserTable();
}

function reinitializeUserTable() {
    $('#user-table').DataTable().destroy();
    createUserTable();
}

function getUserDataForForm(id) {
    // TODO: wyslij request do backendu z id, pobierz usera z danych
    // TODO: wprowadz dane usera do formularza
}

function clearUserForm() {
    document.getElementById('user-id').value = null;
    document.getElementById('user-name').value = null;
    document.getElementById('user-lastname').value = null;
    document.getElementById('user-login').value = null;
    document.getElementById('user-password').value = null;
    document.getElementById('user-email').value = null;
}

function saveUserForm() {
    var url = HOST + '/api/dodajUsera';
    var formData = {
        id: document.getElementById('user-id').value,
        name: document.getElementById('user-name').value,
        lastname: document.getElementById('user-lastname').value,
        login: document.getElementById('user-login').value,
        password: document.getElementById('user-password').value,
        email: document.getElementById('user-email').value
    };

    var response = JSON.parse(httpPost(url, formData));
    console.info(response.name);
    // response.creationDate - wywala jakas dziwna date
    userTableData.push([response.id, response.name, response.lastname, response.login, new Date(response.creationDate)]);
    // TODO: wyslij request do backendu z powyzszym obiektem, zapisz usera w danych, przypisz mu ID
    reinitializeUserTable();
}

function deleteSelectedUser() {
    var url = HOST + '/api/usunUsera';
    var params = '?id=' + document.getElementById('user-id').value;
    httpGet(url + params);
    // TODO: wyslij request do backendu z id, usun usera z danych
    reinitializeUserTable();
}