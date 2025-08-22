document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("regForm");
  const pages = ["page1", "page2"];
  let currentPage = 0;

  const prevBtn = document.getElementById("prevBtn");
  const nextBtn = document.getElementById("nextBtn");
  const pageIndicator = document.getElementById("pageIndicator");
  const progressBar = document.getElementById("progressBar");

  const disabilityStatusSelect = document.getElementById("disabilityStatus");
  const disabilityTypeContainer = document.getElementById("disabilityTypeContainer");

  function showPage(index) {
    pages.forEach((pageId, i) => {
      document.getElementById(pageId).classList.toggle("hidden", i !== index);
    });
    pageIndicator.textContent = `Page ${index + 1} of ${pages.length}`;
    prevBtn.disabled = index === 0;
    nextBtn.textContent = index === pages.length - 1 ? "Submit" : "Next";
    progressBar.style.width = `${((index + 1) / pages.length) * 100}%`;
  }

  function validatePage() {
    document.querySelectorAll(".error-message").forEach(el => el.remove());
    document.querySelectorAll(".input-error").forEach(el => el.classList.remove("input-error"));

    const inputs = document.querySelectorAll(`#${pages[currentPage]} [required]`);
    let isValid = true;

    for (const input of inputs) {
      const errorMessage = document.createElement("p");
      errorMessage.classList.add("error-message");

      if (input.type === "radio") {
        const radios = document.getElementsByName(input.name);
        if (![...radios].some(r => r.checked)) {
          errorMessage.textContent = `Please select ${input.name.replace(/([A-Z])/g, " $1")}`;
          input.closest("div").appendChild(errorMessage);
          isValid = false;
        }
      } else if (!input.value.trim()) {
        errorMessage.textContent = `Please fill the ${input.previousElementSibling?.textContent.replace("*", "").trim() || input.name}`;
        input.classList.add("input-error");
        input.parentNode.appendChild(errorMessage);
        isValid = false;
      } else if (input.pattern && !new RegExp(input.pattern).test(input.value)) {
        errorMessage.textContent = `Invalid format in ${input.previousElementSibling?.textContent.replace("*", "").trim()}`;
        input.classList.add("input-error");
        input.parentNode.appendChild(errorMessage);
        isValid = false;
      }
    }

    return isValid;
  }

  function buildNestedFormData(form) {
    const formData = new FormData(form);
    const flat = {};
    for (const [key, value] of formData.entries()) {
      flat[key] = value;
    }

    return {
      studentId: flat.studentID,
      admission: {
        dateOfAdmission: flat.dateAdmission,
        class: flat.classSelect,
        gender: flat.gender,
        dob: flat.dob,
        age: flat.age,
        placeOfBirth: flat.placeOfBirth,
        residential: flat.residential,
        remark: flat.remark,
        satsNo: flat.satano,
        penNo: flat.penno,
        udiseTcStatus: flat.udisetcstatus,
        tcInDate: flat.tcindate,
        tcReceived: flat.tcreceived,
        schoolPlace: flat.schoolPlace
      },
      aadharInfo: {
        studentName: flat.studentName,
        studentAadharNo: flat.studentAadhar,
        studentRdNo:flat.studentRdNo
      },
      parents: {
        father: {
          name: flat.fatherName,
          aadharNo: flat.fatherAadhar,
          occupation: flat.fatherOccupation,
          annualIncome: flat.AnnualIncome
        },
        mother: {
          name: flat.motherName,
          aadharNo: flat.motherAadhar,
          occupation: flat.motherOccupation
        },
        guardian: {
          name: flat.guardianName,
          contactNo: flat.guardianContact
        }
      },
      personalDetails: {
        nationality: flat.nationality,
        caste: flat.caste,
        scheduledCategory: flat.category,
        noOfDependents: flat.dependents,
        motherTongue: flat.motherTongue,
        disability: {
          status: flat.disability,
          type: flat.disabilityType
        }
      },
      previousSchool: {
        schoolName: flat.schoolName,
        address: {
          village: flat.villageArea,
          taluk: flat.taluk,
          district: flat.district,
          pin: flat.pincode,
          contactNo: flat.schoolContact
        }
      },
      address: {
        parentsAddress: {
          village: flat.parentVillage,
          taluk: flat.parentTaluk,
          district: flat.parentDistrict,
          pin: flat.parentPincode,
          contactNo: flat.parentContact
        },
        guardianAddress: {
          village: flat.guardianVillage,
          taluk: flat.guardianTaluk,
          district: flat.guardianDistrict,
          pin: flat.guardianPincode,
          contactNo: flat.guardianContact
        }
      }
    };
  }

  async function performHttpRequest(url, headers, body) {
    try {
      const res = await fetch(url, {
        method: "POST",
        headers: headers,
        body: JSON.stringify(body)
      });
      return await res.json();
    } catch (err) {
      console.error("Error at fetch POST:", err);
      throw err;
    }
  }

  function buildHeaders() {
    return new Headers({ "Content-Type": "application/json" });
  }

  nextBtn.addEventListener("click", async (e) => {
    if (!validatePage()) return;

    if (currentPage === pages.length - 1) {
      e.preventDefault();
      nextBtn.disabled = true;

      const headers = buildHeaders();
      const jsonFormData = buildNestedFormData(form);

      try {
        const response = await performHttpRequest("http://localhost:8080/api/student", headers, jsonFormData);
        console.log("Server Response:", response);
        alert("Form submitted successfully!");
        form.reset();
        currentPage = 0;
        showPage(currentPage);
      } catch (error) {
        alert("Error submitting form");
      } finally {
        nextBtn.disabled = false;
      }
    } else {
      currentPage++;
      showPage(currentPage);
    }
  });

  prevBtn.addEventListener("click", () => {
    if (currentPage > 0) {
      currentPage--;
      showPage(currentPage);
    }
  });

  if (disabilityStatusSelect && disabilityTypeContainer) {
    disabilityStatusSelect.addEventListener("change", () => {
      if (disabilityStatusSelect.value.toLowerCase() === "yes") {
        disabilityTypeContainer.classList.remove("hidden");
      } else {
        disabilityTypeContainer.classList.add("hidden");
        document.getElementById("disabilityType").value = "";
      }
    });
  }

  //  Age auto-calculates
  const dobInput = document.getElementById('dob');
  const ageInput = document.getElementById('age');

  if (dobInput && ageInput) {
    dobInput.addEventListener('change', function () {
      const dobValue = this.value;

      if (!dobValue || !dobValue.match(/^\d{4}-\d{2}-\d{2}$/)) {
        ageInput.value = '';
        return;
      }

      const dob = new Date(dobValue);
      const today = new Date();

      let age = today.getFullYear() - dob.getFullYear();
      const m = today.getMonth() - dob.getMonth();

      if (m < 0 || (m === 0 && today.getDate() < dob.getDate())) {
        age--;
      }

      ageInput.value = age >= 0 ? age : '';
    });
  }

  // Gurdian Address  Make Same As Parent
   const sameAsParentCheckbox = document.getElementById("sameAsParent");
    if (sameAsParentCheckbox) {
      sameAsParentCheckbox.addEventListener("change", () => {
        const parentVillage = document.getElementById("parentVillage");
        const parentTaluk = document.getElementById("parentTaluk");
        const parentDistrict = document.getElementById("parentDistrict");
        const parentPincode = document.getElementById("parentPincode");
        const parentContact = document.getElementById("parentContact");

        const guardianVillage = document.getElementById("guardianVillage");
        const guardianTaluk = document.getElementById("guardianTaluk");
        const guardianDistrict = document.getElementById("guardianDistrict");
        const guardianPincode = document.getElementById("guardianPincode");
        const guardianContact = document.getElementById("guardianContact");

        if (sameAsParentCheckbox.checked) {
          guardianVillage.value = parentVillage.value;
          guardianTaluk.value = parentTaluk.value;
          guardianDistrict.value = parentDistrict.value;
          guardianPincode.value = parentPincode.value;
          guardianContact.value = parentContact.value;

          guardianVillage.disabled = true;
          guardianTaluk.disabled = true;
          guardianDistrict.disabled = true;
          guardianPincode.disabled = true;
          guardianContact.disabled = true;
        } else {
          guardianVillage.disabled = false;
          guardianTaluk.disabled = false;
          guardianDistrict.disabled = false;
          guardianPincode.disabled = false;
          guardianContact.disabled = false;
        }
      });
    }


  // Show first page
  const submit=document.getElementById("submitBtn");
  submit.addEventListener("click", async (e) => {
    e.preventDefault();

    // Validate current page before submitting
    if (!validatePage()) return;

    submit.disabled = true;  // Disable button to prevent multiple clicks

    const headers = buildHeaders();
    const jsonFormData = buildNestedFormData(form);

    try {
      const response = await performHttpRequest("http://localhost:8080/api/student", headers, jsonFormData);
      console.log("Server Response:", response);
      alert("Form submitted successfully!");
      form.reset();
      currentPage = 0;
      showPage(currentPage);
    } catch (error) {
      console.error("Submit error:", error);
      alert("Error submitting form. Please try again.");
    } finally {
      submit.disabled = false;  // Re-enable button after submission attempt
    }
  });
 });
