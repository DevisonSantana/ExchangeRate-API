## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## API Access

Your API Key: **e823d0f9bf341fc53964a7ca**

Example Request:

> https://v6.exchangerate-api.com/v6/e823d0f9bf341fc53964a7ca/latest/USD

> https://v6.exchangerate-api.com/v6/e823d0f9bf341fc53964a7ca/codes

> https://v6.exchangerate-api.com/v6/e823d0f9bf341fc53964a7ca/pair/USD/BRL

## PROJETO

### latest

> args: `$code` <br>
> keyword: `"conversion_rates"` <br>
> response type: `Object`

### codes

> args: none <br>
> keyword: `"suported_codes"` <br>
> response type: `List`

### pair
> args: `$code + $code + $value` <br>
> keywords: `["conversion_rate", "conversion_result"]` <br>
> response type: `double`