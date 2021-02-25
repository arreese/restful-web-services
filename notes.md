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

## Static Filtering
- @JsonIgnore : excludes the field from the response, better in the case of renaming
    - Configure directly on the Bean

## Dynamic Filtering
- Cannot configure directly on the Bean
