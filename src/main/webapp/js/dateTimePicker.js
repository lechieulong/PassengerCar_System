const datetimeInput = document.getElementById("datetimeInput");
const currentDate = new Date();

flatpickr(datetimeInput, {
    enableTime: true,
    minDate: "today",
    defaultDate: currentDate,
    dateFormat: "Y-m-d H:i",
    time_24hr: true,
});