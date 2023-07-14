const hourSelect = document.getElementById("hourSelect");
const minuteSelect = document.getElementById("minuteSelect");

const populateOptions = (select, start, end) => {
    for (let i = start; i <= end; i++) {
        const option = new Option(i.toString().padStart(2, "0"), i);
        select.add(option);
    }
};

populateOptions(hourSelect, 1, 12);
populateOptions(minuteSelect, 0, 59);