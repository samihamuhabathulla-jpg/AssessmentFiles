 document.querySelector("form").addEventListener("submit", function(e) {

    let valid = true;

    document.querySelectorAll(".error").forEach(el => el.remove());

    let name = document.querySelector("input[name='fullname']");
    if (name.value.trim() === "") {
        showError(name, "Full Name is required");
        valid = false;
    }

    let email = document.querySelector("input[name='email']");
    if (!email.value.includes("@") || !email.value.endsWith(".com")) {
        showError(email, "Enter valid email");
        valid = false;
    }

    let dob = document.querySelector("input[name='dob']").value;
    if (dob === "") {
        showError(document.querySelector("input[name='dob']"), "Enter DOB");
        valid = false;
    } else {
        let age = new Date().getFullYear() - new Date(dob).getFullYear();
        if (age < 17) {
            showError(document.querySelector("input[name='dob']"), "Must be at least 17 years old");
            valid = false;
        }
    }

    let course = document.querySelector("select");
    if (course.selectedIndex === 0) {
        showError(course, "Please select a course");
        valid = false;
    }

    if (!valid) {
        e.preventDefault();
    }
});

function showError(element, message) {
    let error = document.createElement("div");
    error.className = "error";
    error.style.color = "red";
    error.textContent = message;
    element.after(error);
}