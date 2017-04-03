function switchMenu(htmlPath) {
    $("#submenu").unload();
    $("#submenu").load(htmlPath);
};

function switchTab(htmlPath) {
    $("#content").unload();
    $("#content").load(htmlPath);
};