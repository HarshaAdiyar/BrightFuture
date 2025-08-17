document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("studentForm");

  form.addEventListener("submit", (e) => {
    e.preventDefault(); // stop page refresh

    // Collect form data
    const formData = new FormData(form);
    const data = {};
    formData.forEach((value, key) => {
      data[key] = value;
    });

    // Save to localStorage
    localStorage.setItem("page1Data", JSON.stringify(data));

    // Redirect to Page 2
    window.location.href = "page2.html";
  });
});
