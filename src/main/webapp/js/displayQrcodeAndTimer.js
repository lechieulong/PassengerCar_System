function displayQRCodeAndTimer() {
    const qrCodeImage = document.getElementById("qrCode");
    const countdownTimer = document.getElementById("countdownTimer");
    const countdownDuration = 180; // Countdown duration in seconds (3 minutes)

    // TODO: Generate or fetch the actual QR code image URL
    const qrCodeURL = "path/to/qr-code-image.png";
    qrCodeImage.src = qrCodeURL;

    // Start the countdown timer
    let remainingTime = countdownDuration;
    updateCountdownTimer();

    const countdownInterval = setInterval(() => {
        remainingTime--;
        updateCountdownTimer();

        if (remainingTime <= 0) {
            clearInterval(countdownInterval);
            // TODO: Handle timeout event, e.g., cancel the ticket if payment is not completed
        }
    }, 1000);

    // Function to update the countdown timer display
    function updateCountdownTimer() {
        const minutes = Math.floor(remainingTime / 60);
        const seconds = remainingTime % 60;
        countdownTimer.textContent = `Thời gian còn lại: ${minutes}:${seconds.toString().padStart(2, "0")}`;
    }
}

// Function to handle the payment confirmation button click event
function confirmPayment() {
    // Perform payment processing here

    // Display the QR code and start the countdown timer
    displayQRCodeAndTimer();

    // Close the confirmation modal
    const confirmationModal = document.getElementById("confirmationModal");
    const bootstrapModal = bootstrap.Modal.getInstance(confirmationModal);
    bootstrapModal.hide();
}

// Event listener for the confirmation modal show event
document.getElementById("confirmationModal").addEventListener("show.bs.modal", function (event) {
    // Clear the QR code and countdown timer when the modal is shown
    document.getElementById("qrCode").src = "";
    document.getElementById("countdownTimer").textContent = "";
});