const myModal = document.getElementById('modalSignin')
const myInput = document.getElementById('floatingInput')

myModal.addEventListener('shown.bs.modal', () => {
    myInput.focus()
})