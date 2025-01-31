const { createGlobPatternsForDependencies } = require('@nx/angular/tailwind');
const { join } = require('path');

/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    join(__dirname, 'src/**/!(*.stories|*.spec).{ts,html}'),
    ...createGlobPatternsForDependencies(__dirname),
  ],
  safelist: [
    'bg-teal-800',
    'bg-secondary',
    'menu-sm',
    'menu-lg',
  ],
  theme: {
    fontFamily: {
      sans: ['Inter var', 'ui-sans-serif', 'system-ui'], // Custom font families for sans-serif text.
      serif: ['Inter var', 'ui-serif', 'Georgia'], // Custom font families for serif text.
    },
    fontSize: {
      sm: '0.875rem', // Small font size (14px).
      base: '1.3rem', // Base font size (20.8px).
      xl: '1.55rem', // Extra-large font size (24.8px).
      '2xl': '1.563rem', // 2x large font size (25px).
      '3xl': '1.953rem', // 3x large font size (31.3px).
      '4xl': '2.441rem', // 4x large font size (39.1px).
      '5xl': '3.052rem', // 5x large font size (48.8px).
      '6xl': '3.815rem', // 6x large font size (61px).
    },
    extend: {
      colors: {
        // Define custom colors or override default Tailwind CSS colors.
        primary: '#1E40AF', // Example: dark blue.
        secondary: '#F6F6F6', // Example: light gray.
        accent: '#9333EA', // Example: purple.
        neutral: '#374151', // Example: dark gray.
      },
    },
  },
  daisyui: {
    themes: [
      {
        fantasy: {
          primary: '#0000ff', // Blue for the primary color.
          'primary-content': 'white', // White text for elements using the primary color.
          secondary: '#F6F6F6', // Light gray for secondary elements.
        },
      },
    ],
  },
  plugins: [
    require('@tailwindcss/forms'), // Plugin for styling forms.
     // DaisyUI plugin for pre-designed UI components.
  ],
};
