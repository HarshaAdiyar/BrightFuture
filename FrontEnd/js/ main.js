// Wait until DOM is loaded
document.addEventListener('DOMContentLoaded', () => {
  const page1 = document.getElementById('page1');
  const page2 = document.getElementById('page2');
  const nextBtn = document.getElementById('nextBtn');
  const prevBtn = document.getElementById('prevBtn');
  const form = document.getElementById('registration-form');

  // Navigation: Next and Previous
  nextBtn.addEventListener('click', () => {
    page1.classList.add('hidden');
    page2.classList.remove('hidden');
    window.scrollTo({ top: 0, behavior: 'smooth' });
  });

  prevBtn.addEventListener('click', () => {
    page2.classList.add('hidden');
    page1.classList.remove('hidden');
    window.scrollTo({ top: 0, behavior: 'smooth' });
  });

  // Auto-calculate Age on Date of Birth change (Page 1)
  const dobInput = document.getElementById('dob');
  const ageInput = document.getElementById('age');
  if (dobInput && ageInput) {
    dobInput.addEventListener('change', function() {
      const dob = new Date(this.value);
      const today = new Date();
      let age = today.getFullYear() - dob.getFullYear();
      const m = today.getMonth() - dob.getMonth();
      if (m < 0 || (m === 0 && today.getDate() < dob.getDate())) age--;
      ageInput.value = age > 0 ? age : '';
    });
  }

  // Disability Status - enable Disability Type select only if 'Yes' is checked (Page 2)
  const disabilityRadios = page2.querySelectorAll('input[name="disability"]');
  const disabilityTypeSelect = page2.querySelector('select[disabled]');
  disabilityRadios.forEach(radio => {
    radio.addEventListener('change', () => {
      if (radio.value === 'Yes' && radio.checked) {
        disabilityTypeSelect.disabled = false;
        disabilityTypeSelect.classList.remove('bg-blue-100');
      } else if (radio.value === 'No' && radio.checked) {
        disabilityTypeSelect.disabled = true;
        disabilityTypeSelect.selectedIndex = 0;
        disabilityTypeSelect.classList.add('bg-blue-100');
      }
    });
  });

  // Copy Parent's Address to Guardian's Address
  const sameAsParentCheckbox = document.getElementById('sameAsParent');
  if (sameAsParentCheckbox) {
    sameAsParentCheckbox.addEventListener('change', () => {
      // Parent's Address Inputs (first grid in Address Info section on Page 2)
      const parentAddressSection = page2.querySelector('label:contains("Parent\'s Address") + .grid, label:contains("Parent\'s Address") ~ .grid');
      const guardianAddressSection = page2.querySelector('label:contains("Guardian\'s Address") + .grid, label:contains("Guardian\'s Address") ~ .grid');

      // Fallback to position-based selection if needed:
      const addressGrids = page2.querySelectorAll('.grid.grid-cols-1.md\\:grid-cols-3');
      const parentFields = addressGrids[0] ? addressGrids.querySelectorAll('input') : [];
      const guardianFields = addressGrids[1] ? addressGrids[1].querySelectorAll('input') : [];

      if (sameAsParentCheckbox.checked) {
        parentFields.forEach((input, idx) => {
          if (guardianFields[idx]) {
            guardianFields[idx].value = input.value;
            guardianFields[idx].readOnly = true;
            guardianFields[idx].classList.add('bg-blue-200');
          }
        });
      } else {
        guardianFields.forEach(input => {
          input.value = '';
          input.readOnly = false;
          input.classList.remove('bg-blue-200');
        });
      }
    });
  }

  // Form submission handler with simple alert
  form.addEventListener('submit', (e) => {
    e.preventDefault();
    alert('✅ Registration submitted successfully!');
    // Here you can add code to collect data and send to backend if needed.
  });
});
