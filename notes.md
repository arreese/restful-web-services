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
    - Configure filtering directly on the Bean

## Dynamic Filtering
- Cannot configure filtering directly on the Bean
- Start configuringn the filter where we are retrieving the values
```
On the Controller

@GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filters);

        return mapping;
    }
```

```
On the Bean
@JsonFilter("SomeBeanFilter")

```

## Data Annotation (lombok)
```
@Data   - generates getters and setters
@NoArgsConstructor - generates no argument constructor
@AllArgsConstructor - generates all argument constructor
```
- Compiles less code
