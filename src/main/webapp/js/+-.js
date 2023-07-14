
function submitForm() {
    const quantity = parseInt(document.getElementById("quantity").innerText);
    const totalPrice = parseInt(document.getElementById("totalPrice").innerText);
    document.getElementById("inputQuantity").value = quantity;
    document.getElementById("inputPrice").value = totalPrice;
    document.forms[0].submit();
}

function increaseQuantity() {
    const quantitySpan = document.getElementById("quantity");
    const currentQuantity = parseInt(quantitySpan.innerText);
    quantitySpan.innerText = currentQuantity + 1;
    updateTotalPrice();
}

function decreaseQuantity() {
    const quantitySpan = document.getElementById("quantity");
    const currentQuantity = parseInt(quantitySpan.innerText);
    quantitySpan.innerText = Math.max(currentQuantity - 1, 0);
    updateTotalPrice();
}

function updateTotalPrice() {
    const quantity = parseInt(document.getElementById("quantity").innerText);
    const price = 1000000; // Giá tiền mặc định là 1.000.000 VNĐ
    const totalPrice = quantity * price;
    document.getElementById("totalPrice").innerText = "Tổng tiền: " + formatPrice(totalPrice) + " VNĐ";
    document.getElementById("inputQuantity").value = quantity;
}

// Hàm định dạng số tiền thành chuỗi có dấu phân cách hàng nghìn
function formatPrice(price) {
    return price.toLocaleString("vi-VN");
}

// Gọi hàm updateTotalPrice khi tài liệu đã tải xong
document.addEventListener("DOMContentLoaded", function() {
    updateTotalPrice();
});