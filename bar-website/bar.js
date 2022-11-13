class Bar {
  constructor() {
    this.barEndpoint = 'http://localhost:3000/bar';

    document.addEventListener('DOMContentLoaded', () => {
      this.verify();
    });
  }

  async verify() {
    try {
      const response = await fetch(this.barEndpoint, { method: 'POST' });
      const { success } = await response.json();

      if (success === true) {
        alert('Yay! Everything works');
      } else {
        alert('Unexpected response');
      }
    } catch (error) {
      alert('There has been a problem with the request');
    }
  }
}
