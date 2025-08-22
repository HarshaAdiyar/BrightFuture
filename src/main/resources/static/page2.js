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

    const finalData = {
       studentId: page1Data.studentId,

       admission:{
         dateOfAdmission: page1Data.dateofAdmission,
         className: page1Data.className,
         gender: page1Data.gender,
         dob: page1Data.dob,
         age:parseInt(page1Data.age),
         placeOfBirth: page1Data.placeofBirth,
         remark: page1Data.remark,
         residential: page1Data.residential,
         satsNo: page1Data.satsNo,
         penNo: page1Data.penNo,
         tcInDate: page1Data.tcInDate,
         tcReceived: page1Data.tcReceived,
         schoolPlace: page1Data.schoolPlace
        },

        aadharInfo: {
         studentName:page1Data.studentName,
         studentAadharNo:page1Data.studentAadharNo,
         studentRdNo: page1Data.studentRdNo
        },

        parents: {
           father: {
           name: page1Data.fatherName,
           aadharNo: page1Data.fatherAadhar,
           occupation: page1Data.fatherOccupation,
           annualIncome: parseFloat(page1Data.fatherIncome) || 0
          },
           mother: {
           name: page1Data.motherName,
           aadharNo: page1Data.motherAadhar,
           occupation: page1Data.motherOccupation
          },
           guardian: {
           name: page1Data.guardianName,
           contactNo: page1Data.guardianContact
          }
        },

        personalDetails: {
          nationality: page2Data.nationality,
          caste: page2Data.caste,
          scheduledCategory: page2Data.scheduledCategory,
          noOfDependents: parseInt(page2Data.noOfDependents),
          motherTongue: page2Data.motherTongue,
          disability: page2Data.disability,

          disability: {
             status: page2Data.status,
             type: page2Data.type
            }
        },

        previousSchool: {
           schoolName:page2Data.schoolName,
           schoolContact:page2Data.schoolContact,
           schoolVillage:page2Data.schoolVillage,
           schoolTaluk:page2Data.schoolTaluk,
           schoolDistrict:page2Data.schoolDistrict,
           schoolPin:page2Data.schoolPin
        },

        address: {
          parentsAddress: {
          village: page2Data.parentVillage,
          taluk: page2Data.parentTaluk,
          district: page2Data.parentDistrict,
          pin: page2Data.parentPin,
         contactNo: page2Data.parentContact
           },
         guardianAddress: {
         village: page2Data.guardianVillage,
         taluk: page2Data.guardianTaluk,
        district: page2Data.guardianDistrict,
        pin: page2Data.guardianPin,
        contactNo: page2Data.guardianContact
          }
      }


    };

    console.log("Final Submitted Data:", finalData);


fetch("http://localhost:8080/api/student", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(finalData)
  })
  .then(response => {
    if (!response.ok) {
      throw new Error("Network response was not ok");
    }
    return response.json();
  })
  .then(data => {
    console.log("Server Response:", data);
    alert("Form submitted successfully!");
    form.reset();
    localStorage.removeItem("page1Data");
  })
  .catch(error => {
    console.error("Error submitting data:", error);
    alert("Error submitting registration.");
     });
  });
});