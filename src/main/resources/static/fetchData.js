document.addEventListener("DOMContentLoaded", () => {
  const fetchBtn = document.getElementById("fetchBtn");
  const searchInput = document.getElementById("searchId");
  const detailsTableBody = document.querySelector("#detailsTable tbody");

  // Recursive function to flatten JSON into key-value pairs
  function flattenJSON(obj, parentKey = "", result = {}) {
    for (let key in obj) {
      if (obj.hasOwnProperty(key)) {
        const newKey = parentKey ? `${parentKey}.${key}` : key;
        if (typeof obj[key] === "object" && obj[key] !== null) {
          flattenJSON(obj[key], newKey, result);
        } else {
          result[newKey] = obj[key];
        }
      }
    }
    return result;
  }

  fetchBtn.addEventListener("click", async () => {
    const id = searchInput.value.trim();
    if (!/^\d{5,6}$/.test(id)) {
      alert("Enter a valid 5-6 digit Student ID");
      return;
    }

    try {
      const response = await fetch(`http://localhost:8080/api/student/${id}`);
      if (!response.ok) throw new Error("Student not found");

      const data = await response.json();
      console.log("Fetched Student:", data);

      // Flatten JSON
      const flatData = flattenJSON(data);

      // Clear previous rows
      detailsTableBody.innerHTML = "";

      // Add rows dynamically
      Object.entries(flatData).forEach(([key, value]) => {
        const row = document.createElement("tr");
        row.innerHTML = `<td>${key}</td><td>${value}</td>`;
        detailsTableBody.appendChild(row);
      });

    } catch (err) {
      console.error("Error fetching student:", err);
      alert("Could not fetch student details.");
    }
  });
});
