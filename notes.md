# Notes

### Internationalization
- Customizing your services for different people around the world
### Configuration
- LocalResolver
    - Default Locale - Local.US
- ResourceBundleMessageSource
### Usage
- Autowire MessageSource
- @RequestHEader(value = "Accept-Language", required = false) Locale locale
- messageSource.getMessage("helloWorld.message", null, locale)