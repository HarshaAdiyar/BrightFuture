// ===== Dynamic Backend URL =====
const API_BASE_URL = window.location.origin;
// Example: if page is opened at http://localhost:8080/Index.html
// then API_BASE_URL = http://localhost:8080

// ===== View All Students =====
const viewAllBtn = document.getElementById("viewAllBtn");
if (viewAllBtn) {
    viewAllBtn.addEventListener("click", async () => {
        try {
            const res = await fetch(`${API_BASE_URL}/api/student`);
            if (!res.ok) throw new Error("Failed to fetch students");

            const students = await res.json();
            console.log("📋 All Students:", students);
            populateStudentsTable(students);
        } catch (err) {
            console.error("❌ Error loading students:", err);
            alert("❌ Failed to load students.");
        }
    });
}

// ===== Add Student =====
const studentForm = document.getElementById("studentForm");
if (studentForm) {
    studentForm.addEventListener("submit", async (e) => {
        e.preventDefault();
        toggleSubmit();

        try {
            const formData = new FormData(studentForm);
            const studentObj = Object.fromEntries(formData.entries());

            const res = await fetch(`${API_BASE_URL}/api/student`, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(studentObj)
            });

            if (!res.ok) throw new Error(await res.text());

            const saved = await res.json();
            console.log("✅ Student saved:", saved);
            alert("✅ Submitted & saved successfully!");
            studentForm.reset();
            toggleSubmit();
        } catch (err) {
            console.error("❌ Submit failed:", err);
            alert("❌ Submit failed. See console for details.");
        }
    });
}
