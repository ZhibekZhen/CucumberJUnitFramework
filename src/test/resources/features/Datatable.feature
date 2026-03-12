Feature: to practice datatables

  Scenario Outline: convert datatable to list
    Given the following clininc departments exist:
      | Cardiology |
      | Neurology  |
      | Pediatrics |
      | Oncology   |

    When patient selects "desease" in each department
      | Pediatrics |
      | Oncology   |

    And patient selects 3 appointments or doctor "<doctor>" at hospital "<hospital>"
    And patient selects guests list
      | Sarah | friend |
      | John  | father |
      | Jenny | sister |
    Examples:
      | doctor | hospital   |
      | Chen   | Aurora     |
      | Connor | Naperville |
      | Anna   | Texas      |

