const x = document.getElementById("form__input"),
    y = document.getElementById("y_select"),
    r = document.getElementById("r_select"),
    form = document.getElementById("form"),
    buttons = document.querySelectorAll(".y_button"),
    r_classList = document.querySelectorAll(".radio_input"),
    check_button = document.getElementById("check__button");

function checkX() {
    let xVal = x.value;
    if (xVal === '') {
        return false;
    }
    if (xVal > 2 || xVal < -4 || xVal === '.') {
        x.classList.add("error");
        return false;
    }
    x.classList.remove("error");
    return true;
}

function checkY() {
    if (y.value === "") {
        buttons.forEach(button => button.classList.add("error"));
        return false;
    }
    buttons.forEach(button => button.classList.remove("error"));
    // canvasContainer.classList.remove("error");
    return true;
}

function changeY(yValue) {
    let button = document.getElementById("y_" + yValue);
    if (!button.classList.contains("selected")) {
        y.value = yValue;
        let oldSelectedButton = document.querySelector(".selected");
        if (oldSelectedButton !== null)
            oldSelectedButton.classList.remove("selected");
        button.classList.add("selected");
        checkY();
    } else {
        y.value = "";
        button.classList.remove("selected");
    }
}

function getRValue(value) {
    r.value = value;
    console.log(r.value);
}

function checkR() {
    if (r.value === '') {
        r_classList.forEach(item => item.classList.add("error"));
        return false;
    }
    r_classList.forEach(item => item.classList.remove("error"));
    return true;
}

function validateData() {
    if (!checkX()) {
        check_button.disabled = true;
    } else if (!checkY()) {
        check_button.disabled = true;
    } else if (!checkR()) {
        check_button.disabled = true;
    } else {
        check_button.disabled = false;
    }
}

setInterval(validateData, 100);