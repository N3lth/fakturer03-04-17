function httpGet(fullRequestPathWithParams) {
    var xmlHttp = new XMLHttpRequest();
    console.info('GET ' + fullRequestPathWithParams);
    xmlHttp.open('GET', fullRequestPathWithParams, false);
    xmlHttp.send(null);
    return xmlHttp.response;
}

function httpPost(fullRequestPath, postData) {
    var xmlHttp = new XMLHttpRequest();
    console.info('POST ' + fullRequestPath);
    xmlHttp.open('POST', fullRequestPath, false);
    xmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlHttp.send(JSON.stringify(postData));
    return xmlHttp.response;
}