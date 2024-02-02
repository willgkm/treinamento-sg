import './home.scss'

class homeController {

  private selected: number = 0
  private cardsColumns: number = 3
  private carousel: string[] = [
    'https://img.elo7.com.br/product/zoom/1CFADD3/painel-sublimado-tio-patinhas-2-5x1-5m-cenario-para-fotos.jpg',
    'https://blog.magnetis.com.br/wp-content/uploads/2019/05/pessoas-mais-ricas-do-brasil.jpg',
    'https://freedook.com/dk/wp-content/uploads/2018/08/Os-Segredos-das-Pessoas-Ricas-e-Bem-Sucedidas-7.jpg',
  ]
  private cards: object[] = [
    {
      image: 'https://media-exp1.licdn.com/dms/image/C561BAQG8jBJ-6Uw_2g/company-background_10000/0/1552568277311?e=2159024400&v=beta&t=leAN-aEQwoogMSo3h1UBJKGHDmxf6Sv9KTSZszxKzV8',
      title: 'Banco é o lugar onde você pode obter dinheiro emprestado, se provar que não precisa dele.',
      button: 'Veja mais',
    },{
      image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSEm4nTVSQJFC_tFo0QC1CEUgFsxZCpSp7SUQ&usqp=CAU',
      title: 'O crédito que você precisa agora com até 6 anos pra pagar',
      button: 'Saiba mais',
    },{
      image: 'https://kcm-www.s3.amazonaws.com/production/s3fs-public/daily_confessions_for_financial_victory_1239968128.jpg',
      title: 'Pra fazer um sonho decolar e pra tudo que você imaginar',
      button: 'Vem ser cliente',
    }

  ]

  constructor(
    public $scope,
    public $state,
    public $interval,
  ) { }
  
  $onInit = () => {
    this.$interval(() => {
      this.forwardCarousel()
    }, 5000)
  }

  goAccountCreate = () => {
    this.$state.go('account.create')
  }

  goAccountManage = () => {
    this.$state.go('account.manage', { id: 1 })
  }

  backwardCarousel = () => {
    if (this.selected == 0) {
      this.selected = 2
      return
    }
    this.selected--
  }

  forwardCarousel = () => {
    if (this.selected == 2) {
      this.selected = 0
      return
    }
    this.selected++
  }

  select = (index: number) => {
    this.selected = index
  }

  getCards = (line: number) => {
    console.log(line)
    console.log(this.cards.slice(line * this.cardsColumns, (line + 1) * this.cardsColumns))
  }


}

homeController['$inject'] = [
  '$scope',
  '$state',
  '$interval',
]


export default homeController;