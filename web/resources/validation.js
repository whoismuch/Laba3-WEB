let button = document.getElementById("newPointForm:checkButton");
let form = document.getElementById("newPointForm");
let messageY = document.getElementById("newPointForm:messageY");
let buttons = [];
let chooseRTitle = document.querySelector('.chooseRTitle');
let selectXTitle = document.querySelector('.selectXTitle');
let selectX = document.getElementById("newPointForm:X_input");
let enterY = document.getElementById("newPointForm:Y");

let decision = 0;
let styleR = chooseRTitle.style;
let styleX = selectXTitle.style;
let styleY = enterY.style;

let isRSuccess = false;
let isXSuccess = false;
let isYSuccess = false;

function cancelButton(button) {
    decision = button.value;
    if (!buttons.includes(button)) buttons.push(button);
    for (var i = 0; i < buttons.length; i++) {
        if (buttons[i].value != decision) buttons[i].disabled = false;
    }
}


form.onsubmit = function (event) {

    event.preventDefault();

    if (decision == 0) {
        chooseRTitle.style.color = 'red';
        isRSuccess = false;
    } else {
        chooseRTitle.style = styleR;
        isRSuccess = true;
    }

    if (!enterY.value) {
        enterY.style.border = '2.5px solid red';
        isYSuccess = false;
    }
    else {
        enterY.style = styleY;
        isYSuccess = true;
    }

    if (!selectX.value) {
        selectXTitle.style.color = 'red';
        isXSuccess = false;
    }
    else {
        selectXTitle.style = styleX;
        isXSuccess = true;
    }

    if (isRSuccess && isXSuccess && isYSuccess) form.submit();


};








