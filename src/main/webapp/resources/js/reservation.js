const form = document.querySelector('form');

form.addEventListener('submit', (event) => {
    event.preventDefault();

    const name = document.querySelector('#name');
    const phone = document.querySelector('#phone');
    const guests = document.querySelector('#guests');
    const date = document.querySelector('#date');
    const time = document.querySelector('#time');

    if (name.value === '' || phone.value === '' || guests.value === '' || date.value === '' || time.value === '') {
        alert('Please fill in all required fields');
    } else {
        // Submit form data to server or send an email
        alert('Your reservation has been submitted');
    }
});

function getName() {
    const val = document.getElementById('name').value;
}