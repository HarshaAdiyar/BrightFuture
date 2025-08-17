document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("page2Form");

  const page1Data = JSON.parse(localStorage.getItem("page1Data")) || {};
  console.log("Page 1 Data Loaded:", page1Data);

  const disabilityRadios = document.querySelectorAll('input[name="disability_status"]');
  const disabilityType = document.getElementById("disabilityType");

  disabilityRadios.forEach(radio => {
    radio.addEventListener("change", () => {
      disabilityType.disabled = (radio.value === "no");
    });
  });

  const sameCheckbox = document.querySelector('input[name="guardianSame"]');
  sameCheckbox.addEventListener("change", () => {
    if (sameCheckbox.checked) {
      document.getElementById("guardianVillage").value = document.getElementById("parentVillage").value;
      document.getElementById("guardianTaluk").value = document.getElementById("parentTaluk").value;
      document.getElementById("guardianDistrict").value = document.getElementById("parentDistrict").value;
      document.getElementById("guardianPin").value = document.getElementById("parentPin").value;
      document.getElementById("guardianContact").value = document.getElementById("parentContact").value;
    } else {

      document.getElementById("guardianVillage").value = "";
      document.getElementById("guardianTaluk").value = "";
      document.getElementById("guardianDistrict").value = "";
      document.getElementById("guardianPin").value = "";
      document.getElementById("guardianContact").value = "";
    }
  });

  // Handle form submission
  form.addEventListener("submit", (e) => {
    e.preventDefault();

    const formData = new FormData(form);
    const page2Data = {};
    formData.forEach((value, key) => {
      page2Data[key] = value;
    });

    const finalData = { ...page1Data, ...page2Data };

    console.log("Final Submitted Data:", finalData);

    localStorage.removeItem("page1Data");

    alert("Registration submitted successfully!");
  });
});
