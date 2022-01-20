export interface ExchangeRatesResponse {

    conversion_rates: {
        [key: string]: number
    },
    base_code: string

}
