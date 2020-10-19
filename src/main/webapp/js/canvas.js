let canvasContainer = document.getElementById("visualization_container");
let canvas = document.getElementById("areas");
let ctx = canvas.getContext("2d");
let width = 320;
let canvasR = 117;

canvas.addEventListener("click", function (e) {
    let canvasX = e.pageX - this.offsetLeft,
        canvasY = e.pageY - this.offsetTop;
    if (checkR()) {
        sendDataToForm(canvasX - width / 2, width / 2 - canvasY);
        drawPoints(canvasX, canvasY);
    } else canvasContainer.classList.add("error");
});

window.onload = function () {
    let coordinateX = document.querySelectorAll(".x_cell");
    let coordinateY = document.querySelectorAll(".y_cell");
    let coordinateR = document.querySelectorAll(".r_cell");
    for (let i = 0; i < coordinateX.length; i++) {
        console.log(coordinateX[i].innerHTML * canvasR / coordinateR[i].innerHTML, coordinateY[i].innerHTML * canvasR / coordinateR[i].innerHTML);
        drawPoints(coordinateX[i].innerHTML * canvasR / coordinateR[i].innerHTML + width / 2, width / 2 - coordinateY[i].innerHTML * canvasR / coordinateR[i].innerHTML);
    }
};

function sendDataToForm(xVal, yVal) {
    x.value = Math.round(xVal * r.value / canvasR);
    y.value = (yVal * r.value / canvasR).toString().substr(0, 6);
    form.submit();
}

function drawPoints(canvasX, canvasY) {
    ctx.beginPath();
    ctx.arc(canvasX, canvasY, 3, 0, 2 * Math.PI);
    ctx.fillStyle = "#E40045";
    ctx.fill();
    console.log(`${canvasX - width / 2} ${width / 2 - canvasY}`);
    ctx.closePath();
}