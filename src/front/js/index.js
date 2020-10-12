let form = document.getElementById("#form"),
    x = document.getElementById("form__input"),
    y = document.getElementById("y_select"),
    r = document.getElementById("r_select"),
    check_button = document.getElementById("check__button");

function checkX() {
    let xVal = x.value;
    if ((xVal > 2 || xVal < -4) || !/^[0-9 | . | -]+$/i.test(xVal)) {
        x.classList.add("error");
        return false;
    }
    x.classList.remove("error");
    return true;
}

function checkY() {
    let buttons = document.querySelectorAll(".y_button");
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

function checkR() {
    if (r.value === "") {
        r.classList.add("error");
        return false;
    }
    return true;
}

function validateData() {
    if(!checkX()) {
        check_button.disabled = true;
    }
    else if(!checkY()) {
        check_button.disabled = true;
    } 
    else if(!checkR()) {
        check_button.disabled = true;
    }
    else {
        check_button.disabled = false;
        console.log('goo');
    }
}

setInterval(validateData,100);