USE [TestDB]
GO

CREATE TABLE [dbo].[author](
	[id] [bigint] IDENTITY(1,1) PRIMARY KEY,
	[first_name] [varchar](max) NULL,
	[last_name] [varchar](max) NULL
	)

CREATE TABLE [dbo].[book](
	[id] [bigint] IDENTITY(1,1) PRIMARY KEY,
	[isbn] [varchar](255) NULL,
	[title] [varchar](255) NULL,
	[publisher_id] [bigint] NULL
	)

CREATE TABLE [dbo].[publisher](
	[id] [bigint] IDENTITY(1,1) PRIMARY KEY,
	[address] [varchar](255) NULL,
	[name] [varchar](255) NULL
	)


ALTER TABLE [dbo].[book] ADD  CONSTRAINT [FK_book_publisher_publisher_id] FOREIGN KEY([publisher_id])
REFERENCES [dbo].[publisher] ([id])
GO

CREATE TABLE [dbo].[author_book](
	[book_id] [bigint] NOT NULL,
	[author_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[book_id] ASC,
	[author_id] ASC
)

ALTER TABLE [dbo].[author_book] ADD  CONSTRAINT [FK_author_book_author_id] FOREIGN KEY([author_id])
REFERENCES [dbo].[author] ([id])
GO

ALTER TABLE [dbo].[author_book] ADD  CONSTRAINT [FK_author_book_book_id] FOREIGN KEY([book_id])
REFERENCES [dbo].[book] ([id])
GO

-- UserLogin and UserRole table creations
CREATE TABLE [dbo].[UserLogin] (
	[id] [bigint] IDENTITY(1,1) PRIMARY KEY,
    [username] VARCHAR(50) not null UNIQUE,
    [password] NVARCHAR(MAX) not null,
    [active] bit not null
);

CREATE TABLE [dbo].[UserRole] (
    [id] [bigint] IDENTITY(1,1) PRIMARY KEY,
    [name] VARCHAR(50) not null UNIQUE,
    [description] VARCHAR(50) not null
);

CREATE TABLE [dbo].[UserLogin_UserRole](
	[UserLogin_id] [bigint] NOT NULL,
	[UserRole_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[UserLogin_id] ASC,
	[UserRole_id] ASC
)
)

ALTER TABLE [dbo].[UserLogin_UserRole] ADD  CONSTRAINT [FK_userLogin_userRole_userLogin_id] FOREIGN KEY([UserLogin_id])
REFERENCES [dbo].[UserLogin] ([id])
GO

ALTER TABLE [dbo].[UserLogin_UserRole] ADD  CONSTRAINT [FK_userLogin_userRole_userRole_id] FOREIGN KEY([userRole_id])
REFERENCES [dbo].[UserRole] ([id])
GO