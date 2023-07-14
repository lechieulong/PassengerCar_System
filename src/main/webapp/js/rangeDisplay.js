
function displayScrollValue() {
    const rangeElement = document.getElementById("myRange");
    const rangeValueElement = document.getElementById("rangeValue");

    rangeValueElement.innerText = "Số lượng ghế trên phương tiện " + rangeElement.value;
}