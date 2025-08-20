// ===== Validation Rules =====
const rules = {
  alpha: /^[A-Za-z\s]+$/,
  alnum: /^[A-Za-z0-9\s]+$/,
  aadhar: /^\d{4}-\d{4}-\d{4}$/,
  phone: /^\d{3}-\d{3}-\d{4}$/,
  pin: /^\d{6}$/,
  digits9: /^\d{9}$/,
  digits6to10: /^\d{6,10}$/
};

function setValidity(input, valid) {
  const err = input.nextElementSibling && input.nextElementSibling.classList.contains("error-msg")
      ? input.nextElementSibling : null;
  input.classList.toggle("valid", valid);
  input.classList.toggle("invalid", !valid);
  if (err) err.classList.toggle("show", !valid);
}

function validateInput(input) {
  const type = input.dataset.validate;
  if (!type) {
    const ok = !input.required || !!input.value.trim();
    setValidity(input, ok);
    return ok;
  }
  let ok = true;
  const val = input.value.trim();
  switch (type) {
    case "alpha": ok = !val || rules.alpha.test(val); break;
    case "alnum": ok = !val || rules.alnum.test(val); break;
    case "pin": ok = !val || rules.pin.test(val); break;
    case "digits9": ok = !val || rules.digits9.test(val); break;
    case "digits6to10": ok = !val || rules.digits6to10.test(val); break;
    default: ok = true;
  }
  if (input.required) ok = ok && !!val;
  setValidity(input, ok);
  return ok;
}

function formatAadhaar(input) {
  let val = input.value.replace(/\D/g, "").slice(0, 12);
  input.value = val.replace(/(\d{4})(?=\d)/g, "$1-");
  const ok = rules.aadhar.test(input.value) || (!input.required && input.value === "");
  setValidity(input, ok);
}

function formatPhone(input) {
  let v = input.value.replace(/\D/g, "").slice(0, 10);
  if (v.length > 6) input.value = `${v.slice(0,3)}-${v.slice(3,6)}-${v.slice(6)}`;
  else if (v.length > 3) input.value = `${v.slice(0,3)}-${v.slice(3)}`;
  else input.value = v;
  const ok = rules.phone.test(input.value) || (!input.required && input.value === "");
  setValidity(input, ok);
}

// ===== Age auto-calc =====
function calculateAge(dob) {
  let birthDate = new Date(dob);
  let age = new Date().getFullYear() - birthDate.getFullYear();
  let m = new Date().getMonth() - birthDate.getMonth();
  if (m < 0 || (m === 0 && new Date().getDate() < birthDate.getDate())) {
      age--;
  }
  return age;
}

// ===== DOM Ready =====
document.addEventListener("DOMContentLoaded", function () {
  const dobField = document.getElementById("dob");
  if (dobField) {
    dobField.addEventListener("change", function () {
      document.getElementById("age").value = calculateAge(this.value);
    });
  }

  const disabilityStatus = document.getElementById("disabilityStatus");
  if (disabilityStatus) {
    disabilityStatus.addEventListener("change", function () {
      const extra = document.getElementById("disabilityExtra");
      if (extra) extra.classList.toggle("hidden", this.value !== "Yes");
    });
  }

  document.querySelectorAll("input[data-validate]").forEach(inp => {
    validateInput(inp);
    inp.addEventListener("input", () => { validateInput(inp); toggleSubmit(); });
    inp.addEventListener("blur", () => validateInput(inp));
  });

  document.querySelectorAll("input[data-format='aadhar']").forEach(inp => {
    formatAadhaar(inp);
    inp.addEventListener("input", () => { formatAadhaar(inp); toggleSubmit(); });
  });

  document.querySelectorAll("input[data-format='phone']").forEach(inp => {
    formatPhone(inp);
    inp.addEventListener("input", () => { formatPhone(inp); toggleSubmit(); });
  });

  const form = document.getElementById("studentForm");
  if (form) {
    form.addEventListener("input", toggleSubmit);

    // ===== Final Submit =====
    form.addEventListener("submit", async function (e) {
      e.preventDefault();
      if (!form.checkValidity()) {
        form.reportValidity();
        return;
      }

      let student = {
        admission: {
          dateOfAdmission: document.getElementById("dateOfAdmission").value,
          className: document.getElementById("className").value,
          gender: document.getElementById("gender").value,
          dob: document.getElementById("dob").value,
          age: calculateAge(document.getElementById("dob").value),
          placeOfBirth: document.getElementById("placeOfBirth").value,
          residential: document.getElementById("residential").value,
          remark: document.getElementById("remark").value,
          satsNo: document.getElementById("satsNo").value,
          penNo: document.getElementById("penNo").value,
          udiseTcStatus: document.getElementById("udiseTcStatus").value,
          tcInDate: document.getElementById("tcInDate").value,
          tcReceived: document.getElementById("tcReceived").value,
          schoolPlace: document.getElementById("schoolPlace").value
        },
        aadharInfo: {
          studentName: document.getElementById("studentName").value,
          studentAadharNo: document.getElementById("studentAadharNo").value,
        },
        parents: {
          father: {
            name: document.getElementById("fatherName").value,
            aadharNo: document.getElementById("fatherAadhar").value,
            occupation: document.getElementById("fatherOccupation").value,
            annualIncome: parseFloat(document.getElementById("fatherAnnualIncome").value) || 0
          },
          mother: {
            name: document.getElementById("motherName").value,
            aadharNo: document.getElementById("motherAadhar").value,
            occupation: document.getElementById("motherOccupation").value
          },
          guardian: {
            name: document.getElementById("guardianName").value,
            contactNo: document.getElementById("guardianContact").value
          }
        },
        personalDetails: {
          nationality: document.getElementById("nationality").value,
          caste: document.getElementById("caste").value,
          scheduledCategory: document.getElementById("scheduledCategory").value,
          noOfDependents: parseInt(document.getElementById("noOfDependents").value) || 0,
          motherTongue: document.getElementById("motherTongue").value,
          disability: {
            status: document.getElementById("disabilityStatus").value,
            type: document.getElementById("disabilityType").value
          }
        },
        previousSchool: {
          schoolName: document.getElementById("prevSchoolName").value,
          address: {
            village: document.getElementById("prevSchoolVillage").value,
            taluk: document.getElementById("prevSchoolTaluk").value,
            district: document.getElementById("prevSchoolDistrict").value,
            pin: document.getElementById("prevSchoolPin").value,
            contactNo: document.getElementById("prevSchoolContact").value
          }
        },
        address: {
          parentsAddress: {
            village: document.getElementById("parentVillage").value,
            taluk: document.getElementById("parentTaluk").value,
            district: document.getElementById("parentDistrict").value,
            pin: document.getElementById("parentPin").value,
            contactNo: document.getElementById("parentContact").value
          },
          guardianAddress: {
            village: document.getElementById("guardianVillage").value,
            taluk: document.getElementById("guardianTaluk").value,
            district: document.getElementById("guardianDistrict").value,
            pin: document.getElementById("guardianPin").value,
            contactNo: document.getElementById("guardianAddressContact").value
          }
        }
      };

      console.log("📩 Final Student object:", student);

      try {
        const res = await fetch("http://localhost:8080/api/students", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(student)
        });
        if (!res.ok) throw new Error(await res.text());

        const saved = await res.json();
        console.log("✅ Student saved:", saved);
        alert("✅ Submitted & saved successfully!");
        form.reset();
      } catch (err) {
        console.error("❌ Submit failed:", err);
        alert("❌ Submit failed. See console for details.");
      }
    });
  }
});

function toggleSubmit() {
  const form = document.getElementById("studentForm");
  const btn = document.getElementById("submitBtn");
  if (!form || !btn) return;
  let allOk = true;
  form.querySelectorAll("input, select").forEach(inp => {
    if (!validateInput(inp)) allOk = false;
  });
  btn.disabled = !allOk;
}
