document.addEventListener("DOMContentLoaded", () => {
  const fetchBtn = document.getElementById("fetchBtn");
  const searchInput = document.getElementById("searchId");
  const detailsTableBody = document.querySelector("#detailsTable tbody");


  const deleteBtn = document.createElement("button");
  deleteBtn.id = "deleteBtn";
  deleteBtn.textContent = "Delete Student";

  deleteBtn.style.display = "none";
  deleteBtn.style.background = "red";
  deleteBtn.style.color = "white";
  deleteBtn.style.padding = "8px 16px";
  deleteBtn.style.border = "none";
  deleteBtn.style.borderRadius = "6px";
  deleteBtn.style.cursor = "pointer";
  deleteBtn.style.marginTop = "12px";


  const boxContainer = document.querySelector(".box");
  if (boxContainer) boxContainer.appendChild(deleteBtn);
  else {
    document.body.appendChild(deleteBtn);
  }

  let currentStudentId = null;


  function flattenJSON(obj, parentKey = "", result = {}) {
    for (let key in obj) {
      if (!Object.prototype.hasOwnProperty.call(obj, key)) continue;
      const newKey = parentKey ? `${parentKey}.${key}` : key;
      if (typeof obj[key] === "object" && obj[key] !== null) {
        flattenJSON(obj[key], newKey, result);
      } else {
        result[newKey] = obj[key];
      }
    }
    return result;
  }


  async function deleteStudent(id) {
    if (!id) return;
    if (!confirm(`Are you sure you want to delete student ${id}? This cannot be undone.`)) return;

    try {
      deleteBtn.disabled = true;
      deleteBtn.textContent = "Deleting...";

      const response = await fetch(`http://localhost:8080/api/student/${id}`, {
        method: "DELETE",
      });

      if (response.ok || response.status === 204) {
        alert(`Student ${id} deleted successfully.`);
        detailsTableBody.innerHTML = "";     // clear shown details
        deleteBtn.style.display = "none";   // hide delete button
        currentStudentId = null;
        searchInput.value = "";              // optional: clear search input
      } else if (response.status === 404) {
        alert(`No student found with ID ${id}.`);
      } else {
        const text = await response.text();
        alert(`Delete failed: ${text || response.status}`);
      }
    } catch (err) {
      console.error("Error deleting student:", err);
      alert("Could not delete student (network/server error).");
    } finally {
      deleteBtn.disabled = false;
      deleteBtn.textContent = "Delete Student";
    }
  }


  deleteBtn.addEventListener("click", () => {
    if (currentStudentId) deleteStudent(currentStudentId);
  });


  fetchBtn.addEventListener("click", async () => {
    const id = searchInput.value.trim();

    if (!/^\d{5,6}$/.test(id)) {
      alert("Enter a valid 5–6 digit Student ID");
      return;
    }

    try {

      fetchBtn.disabled = true;
      fetchBtn.textContent = "Fetching...";

      const response = await fetch(`http://localhost:8080/api/student/${id}`);
      if (!response.ok) {

        detailsTableBody.innerHTML = `<tr><td colspan="2">No student found with ID ${id}</td></tr>`;
        deleteBtn.style.display = "none";
        currentStudentId = null;
        return;
      }

      const data = await response.json();
      const flatData = flattenJSON(data);


      detailsTableBody.innerHTML = "";
      Object.entries(flatData).forEach(([key, value]) => {
        const row = document.createElement("tr");
        const k = document.createElement("td");
        const v = document.createElement("td");
        k.textContent = key;
        v.textContent = value ?? "";
        row.appendChild(k);
        row.appendChild(v);
        detailsTableBody.appendChild(row);
      });


      currentStudentId = id;
      deleteBtn.style.display = "inline-block";

    } catch (err) {
      console.error("Error fetching student:", err);
      alert("Could not fetch student details (network/server error).");
      deleteBtn.style.display = "none";
      currentStudentId = null;
    } finally {
      fetchBtn.disabled = false;
      fetchBtn.textContent = "Fetch Details";
    }
  });
});
