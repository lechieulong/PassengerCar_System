document.addEventListener('DOMContentLoaded', function() {
    const pickUpPointSelect = document.getElementById('pickUpPointSelect');
    const dropOffPointSelect = document.getElementById('dropOffPointSelect');
    const nameInput = document.getElementById('nameInput');
    pickUpPointSelect.addEventListener('change', updateNameInput);
    dropOffPointSelect.addEventListener('change', updateNameInput);
    function updateNameInput() {
        const pickUpOption = pickUpPointSelect.options[pickUpPointSelect.selectedIndex];
        const dropOffOption = dropOffPointSelect.options[dropOffPointSelect.selectedIndex];
        const pickUpCity = pickUpOption.text.split('-')[1].trim();
        const dropOffCity = dropOffOption.text.split('-')[1].trim();
        nameInput.value = pickUpCity + ' - ' + dropOffCity;
    }
});

