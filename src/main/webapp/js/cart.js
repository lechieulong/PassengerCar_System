function increaseQty(qtyId) {
    const location = document.getElementById(qtyId);
    const currentQty = location.value;
    const qty = Number(currentQty) + 1;
    location.value = qty;
}

function decreaseQty(qtyId) {
    const location = document.getElementById(qtyId);
    const currentQty = location.value;
    if (currentQty > 1) {
        const qty = Number(currentQty) - 1;
        location.value = qty;
    }
}