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
           name: page1Data["father.name"],
           aadharNo: page1Data["father.aadharNo"],
           occupation: page1Data["father.occupation"],
           annualIncome: parseFloat["(page1Data.father.income) || 0"]
          },
           mother: {
           name: page1Data["mother.name"],
           aadharNo: page1Data["mother.aadharNo"],
           occupation: page1Data["mother.occupation"]
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
           address: {
                    village: page2Data["address.schoolVillage"],
                    taluk: page2Data["address.schoolTaluk"],
                    district: page2Data["address.schoolDistrict"],
                    pin: page2Data["address.schoolPin"],
                   contactNo: page2Data["address.schoolContact"]
                     }
        },

        address: {
          parentsAddress: {
          village: page2Data["parentsAddress.village"],
          taluk: page2Data["parentsAddress.taluk"],
          district: page2Data["parentsAddress.district"],
          pin: page2Data["parentsAddress.pin"],
         contactNo: page2Data["parentsAddress.contactNo"]
           },
         guardianAddress: {
         village: page2Data["guardianAddress.village"],
         taluk: page2Data["guardianAddress.taluk"],
        district: page2Data["guardianAddress.district"],
        pin: page2Data["guardianAddress.pin"],
        contactNo: page2Data["guardianAddress.contactNo"]
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