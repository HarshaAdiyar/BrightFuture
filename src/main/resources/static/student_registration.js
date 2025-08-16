document.addEventListener("DOMContentLoaded", () => {
  const page1 = document.getElementById("page1");
  const page2 = document.getElementById("page2");
  const prevBtn = document.getElementById("prevBtn");
  const nextBtn = document.getElementById("nextBtn");
  const submitBtn = document.getElementById("submitBtn");
  const progressBar = document.getElementById("progressBar");
  const pageIndicator = document.getElementById("pageIndicator");
  const dobInput = document.getElementById("dob");
  const ageInput = document.getElementById("age");
  const form = document.getElementById("regForm");

  let currentPage = 1;

  function showPage(pageNumber) {
    if (pageNumber === 1) {
      page1.classList.remove("hidden");
      page2.classList.add("hidden");
      prevBtn.disabled = true;
      nextBtn.classList.remove("hidden");
      submitBtn.classList.add("hidden");
      progressBar.style.width = "50%";
      pageIndicator.textContent = "Page 1 of 2";
    } else if (pageNumber === 2) {
      page1.classList.add("hidden");
      page2.classList.remove("hidden");
      prevBtn.disabled = false;
      nextBtn.classList.add("hidden");
      submitBtn.classList.remove("hidden");
      progressBar.style.width = "100%";
      pageIndicator.textContent = "Page 2 of 2";
    }
    currentPage = pageNumber;
  }

  function validatePage(pageNum) {
    const inputs = pageNum === 1
      ? page1.querySelectorAll("input, select")
      : page2.querySelectorAll("input, select");

    for (let input of inputs) {
      if (!input.checkValidity()) {
        input.reportValidity();
        return false;
      }
    }
    return true;
  }

  nextBtn.addEventListener("click", () => {
    if (validatePage(1)) showPage(2);
  });

  prevBtn.addEventListener("click", () => showPage(1));

  form.addEventListener("submit", async (e) => {
    e.preventDefault();

    if (currentPage === 2 && validatePage(2)) {
      // Build JSON matching your Student model
      // Example: Adjust according to your actual form inputs!
      const studentData = {
        studentId: document.getElementById("studentId")?.value || "",  // add your own input IDs here
        admission: {
          className: document.getElementById("className")?.value || "",
          dob: dobInput.value,
          gender: document.getElementById("gender")?.value || ""
          // add other admission fields here if needed
        },
        // add other nested objects like aadharInfo, parents etc. similarly
      };

      try {
        const response = await fetch("http://localhost:8080/api/students", {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(studentData)
        });

        if (response.ok) {
          alert("Student saved successfully!");
          form.reset();
          showPage(1);
          progressBar.style.width = "50%";
          ageInput.value = "";
        } else {
          alert("Failed to save student.");
        }
      } catch (err) {
        console.error("Error:", err);
        alert("Server error.");
      }
    } else if (currentPage === 1) {
      alert("Please fill Page 1 completely before proceeding.");
    }
  });

  dobInput.addEventListener("change", () => {
    const dobValue = dobInput.value;
    if (dobValue) {
      const today = new Date();
      const dobDate = new Date(dobValue);
      let age = today.getFullYear() - dobDate.getFullYear();
      const monthDiff = today.getMonth() - dobDate.getMonth();
      if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < dobDate.getDate())) age--;
      ageInput.value = age >= 0 ? age + " years" : "";
    } else {
      ageInput.value = "";
    }
  });

  showPage(1);
});
