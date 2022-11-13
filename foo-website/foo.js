class Foo {
  constructor() {
    this.fooEndpoint = 'http://localhost:3000/foo';

    document.addEventListener('DOMContentLoaded', () => {
      this.verify();
    });
  }

  async verify() {
    try {
      const response = await fetch(this.fooEndpoint, { method: 'POST' });

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
