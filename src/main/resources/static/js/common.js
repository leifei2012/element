
var serverAddress = "http://127.0.0.1:8080";
//var serverAddress = "http://localhost:9096";
var videoListUrl = serverAddress + "/p?";
var videoEditUrl = serverAddress + "/api/v1/web/videos/edit";
var videoAddUrl = serverAddress + "/api/v1/web/videos/add";
var videoDeleteUrl = serverAddress + "/api/v1/videos";


function home() {
    window.location.href = "home.html";
}

function loginPage() {
    window.location.href = "login.html";
}

function authenticate(){
    if(sessionStorage.getItem("currentUser")==null){
        loginPage();
        return false
    }
    return true;
}

function authorize() {
    sessionStorage.setItem("currentUser", "admin");
}

function loginOut() {
    if(sessionStorage.getItem("currentUser")!=null){
        sessionStorage.setItem("currentUser", null);
    }
    window.location.href = "login.html";
}

//将输入串中的汉字变为UniCode(UTF8),其它字符不变
function toUTF8(input) {
    var wch, x, uch = "", output = "";
    for (x = 0; x < input.length; x++) {
        wch = input.charCodeAt(x);
        if (!(wch & 0xFF80)) {
            output += input.charAt(x);
        } else if (!(wch & 0xF000)) {
            uch = "%" + (wch >> 6 | 0xC0).toString(16) + "%" + (wch & 0x3F | 0x80).toString(16);
            output += uch;
        } else {
            uch = "%" + (wch >> 12 | 0xE0).toString(16) + "%" + (((wch >> 6) & 0x3F) | 0x80).toString(16) + "%" + (wch & 0x3F | 0x80).toString(16);
            output += uch;
        }
    }
    return (output);
}

//将输入串中的UniCode(UTF8编码还原)
function revertUTF8(input) {
    var x, wch, wch1, wch2, uch = "", output = "";
    for (x = 0; x < input.length; x++) {
        if (input.charAt(x) == "%") {
            wch = parseInt(input.charAt(++x) + input.charAt(++x), 16);
            if (!wch) {
                break;
            }
            if (!(wch & 0x80)) {
                wch = wch;
            } else if (!(wch & 0x20)) {
                x++;
                wch1 = parseInt(input.charAt(++x) + input.charAt(++x), 16);
                wch = (wch & 0x1F) << 6;
                wch1 = wch1 & 0x3F;
                wch = wch + wch1;
            } else {
                x++;
                wch1 = parseInt(input.charAt(++x) + input.charAt(++x), 16);
                x++;
                wch2 = parseInt(input.charAt(++x) + input.charAt(++x), 16);
                wch = (wch & 0x0F) << 12;
                wch1 = (wch1 & 0x3F) << 6;
                wch2 = (wch2 & 0x3F);
                wch = wch + wch1 + wch2;
            }
            output += String.fromCharCode(wch);
        } else {
            output += input.charAt(x);
        }
    }
    return (output);
}